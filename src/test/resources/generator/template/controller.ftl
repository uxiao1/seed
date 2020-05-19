package ${basePackage}.web;
import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import java.util.List;

/**
* Created by ${author} on ${date}.
*/
@Api("${modelNameUpperCamel}接口")
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @ApiOperation(value = "添加${modelNameUpperCamel}")
    @PostMapping("/add")
    public Result add(@ApiParam(required = true)${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "删除${modelNameUpperCamel}")
    @PostMapping("/delete")
    public Result delete(@ApiParam(required = true)@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "更新${modelNameUpperCamel}")
    @PostMapping("/update")
    public Result update(@ApiParam(required = true)${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "根据id查询${modelNameUpperCamel}详情")
    @PostMapping("/detail")
    public Result<${modelNameUpperCamel}> detail(@ApiParam(required = true)@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @ApiOperation(value = "根据id查询${modelNameUpperCamel}详情")
    @PostMapping("/list")
    public Result<PageInfo<${modelNameUpperCamel}>> list(@ApiParam(value = "页码",required = false,defaultValue = "0")@RequestParam(defaultValue = "0") Integer page,@ApiParam(value = "一页显示条数",required = false,defaultValue = "0") @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
