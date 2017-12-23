package org.jvue.workflow.controller;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.pagehelper.PageInfo;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.jvue.util.Pager;
import org.jvue.web.model.ResponseBodyTemplate;
import org.jvue.web.model.WebReponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.util.List;
@Controller
@RequestMapping("/flowDefine")
public class FlowDefineController extends ResponseBodyTemplate{
    private static final Logger logger = LoggerFactory.getLogger(FlowDefineController.class);
    @Autowired
    RepositoryService repositoryService;
    //映射一个action
    @RequestMapping("/list")
    @ResponseBody
    public  Object list(HttpServletRequest request,
                        @RequestParam(value = "pageIndex",defaultValue = "1") int pageIndex,
                        @RequestParam(value = "pageSize",defaultValue = "10") int pageSize){

        //输出日志文件

        Long count= repositoryService.createModelQuery().count();
        Pager pager = new Pager(pageSize, pageIndex, count);
        List<Model> list = repositoryService.createModelQuery().listPage(pager.getStartRow(),pageSize) ;
        pager.setList(list);
        //返回一个index.jsp这个视图
        create200Template(pager,"加载成功");
        return create200Template(pager,"加载成功");
    }
    private Object returnModel;
    /**
     * 创建模型
     */
    @ResponseBody
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Object create(@RequestParam(value = "name",  required = false) String name, @RequestParam(value = "key", required = false) String key, @RequestParam(value = "description",required = false) String description,
                       HttpServletRequest request, HttpServletResponse response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode editorNode = objectMapper.createObjectNode();
            editorNode.put("id", "canvas");
            editorNode.put("resourceId", "canvas");
            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
            editorNode.put("stencilset", stencilSetNode);
            Model modelData = repositoryService.newModel();
            ObjectNode modelObjectNode = objectMapper.createObjectNode();
            modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
            description = StringUtils.defaultString(description);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
            modelData.setMetaInfo(modelObjectNode.toString());
            modelData.setName(name);
            modelData.setKey(StringUtils.defaultString(key));
            repositoryService.saveModel(modelData);
            repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));

            JSONObject jsonObject=WebReponseModel.SUCCESS;
            jsonObject.put("bizdata",modelData.getId());
            returnModel=jsonObject;
            logger.info("创建模型成功" ,modelData.getId());
        } catch (Exception e) {
            logger.error("创建模型失败：", e);
            returnModel=WebReponseModel.FAIL;
        }
        return returnModel;
    }

    /**
     * 根据Model部署流程
     */
    @ResponseBody
    @RequestMapping(value = "deploy/{modelId}")
    public Object deploy(@PathVariable("modelId") String modelId, RedirectAttributes redirectAttributes) {
        try {
            Model modelData = repositoryService.getModel(modelId);
            ObjectNode modelNode = (ObjectNode) new ObjectMapper().readTree(repositoryService.getModelEditorSource(modelData.getId()));
            byte[] bpmnBytes = null;

            BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
            bpmnBytes = new BpmnXMLConverter().convertToXML(model);

            String processName = modelData.getName() + ".bpmn20.xml";
            Deployment deployment = repositoryService.createDeployment().name(modelData.getName()).addString(processName, new String(bpmnBytes)).deploy();
            returnModel= WebReponseModel.SUCCESS;
        } catch (Exception e) {
            returnModel= WebReponseModel.FAIL;
            logger.error("根据模型部署流程失败：modelId={}", modelId, e);
        }
        return returnModel;
    }
    @ResponseBody
    @RequestMapping(value = "delete/{modelId}")
    public Object delete(@PathVariable("modelId") String modelId) {
        repositoryService.deleteModel(modelId);
        returnModel= WebReponseModel.SUCCESS;
        return returnModel;
    }
    /**
     * 导出model对象为指定类型
     *
     * @param modelId 模型ID
     * @param type    导出文件类型(bpmn\json)
     */
    @RequestMapping(value = "export/{modelId}/{type}")
    public void export(@PathVariable("modelId") String modelId,
                       @PathVariable("type") String type,
                       HttpServletResponse response) {
        try {
            Model modelData = repositoryService.getModel(modelId);
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
            byte[] modelEditorSource = repositoryService.getModelEditorSource(modelData.getId());

            JsonNode editorNode = new ObjectMapper().readTree(modelEditorSource);
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);

            // 处理异常
            if (bpmnModel.getMainProcess() == null) {
                response.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
                response.getOutputStream().println("no main process, can't export for type: " + type);
                response.flushBuffer();
                return;
            }

            String filename = "";
            byte[] exportBytes = null;

            String mainProcessId = bpmnModel.getMainProcess().getId();

            if (type.equals("bpmn")) {

                BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
                exportBytes = xmlConverter.convertToXML(bpmnModel);

                filename = mainProcessId + ".bpmn20.xml";
            } else if (type.equals("json")) {

                exportBytes = modelEditorSource;
                filename = mainProcessId + ".json";

            }

            ByteArrayInputStream in = new ByteArrayInputStream(exportBytes);
            IOUtils.copy(in, response.getOutputStream());

            response.setHeader("Content-Disposition", "attachment; filename=" + filename);
            response.flushBuffer();
        } catch (Exception e) {
            logger.error("导出model的xml文件失败：modelId={}, type={}", modelId, type, e);
        }
    }
}
