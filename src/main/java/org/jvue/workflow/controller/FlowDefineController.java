package org.jvue.workflow.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.apache.commons.lang3.StringUtils;
import org.jvue.web.model.WebReponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@Controller
@RequestMapping("/flowDefine")
public class FlowDefineController {
    private static final Logger logger = LoggerFactory.getLogger(FlowDefineController.class);
    @Autowired
    RepositoryService repositoryService;
    //映射一个action
    @RequestMapping("/list")
    @ResponseBody
    public  Object list(){
        //输出日志文件
        List<Model> list = repositoryService.createModelQuery().list();
        //返回一个index.jsp这个视图
        return list;
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
            returnModel= WebReponseModel.SUCCESS;
            logger.info("创建模型成功" ,modelData.getId());
        } catch (Exception e) {
            logger.error("创建模型失败：", e);
            returnModel=WebReponseModel.FAIL;
        }
        return returnModel;
    }

}
