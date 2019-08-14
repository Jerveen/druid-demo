package com.sunchong.demo.controller;

import com.sunchong.demo.model.Account;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * @Description: Swagger配置Controller, 启动后访问 http://localhost:8080/swagger-ui.html
 * @Author: sc
 * @CreateDt: 2019-08-14
 */
@RestController
@RequestMapping("/swagger")
public class SwaggerController {

    /**
     * 模拟数据库
     */
    Map<Integer, Account> accountMap = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取用户信息列表", notes = "获取用户信息列表")
    @GetMapping("listAccounts")
    public List<Account> listAccounts() {
        List<Account> accounts = new ArrayList<>(accountMap.values());
        return accounts;
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @ApiImplicitParam(name = "account", value = "用户所需必要信息", required = true, dataType = "Account")
    @PostMapping("addAccount")
    public String addAccount(@RequestBody Account account) {
        accountMap.put(account.getId(), account);
        return "success";
    }

    @ApiOperation(value = "获取用户详情", notes = "根据url的id来获取详细信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/getAccountById/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountMap.get(id);
    }

    @ApiOperation(value = "更新信息", notes = "根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "account", value = "用户实体account", required = true, dataType = "Account")
    })
    @PutMapping("/updateAccountById/{id}")
    public String updateAccountById(@PathVariable Integer id, @RequestBody Account account) {
        Account accountDb = accountMap.get(id);
        accountDb.setAccountName(account.getAccountName());
        accountDb.setAccountPassword(account.getAccountPassword());
        accountDb.setIdNo(account.getIdNo());
        accountMap.put(id, accountDb);
        return "success";
    }

    @ApiOperation(value = "删除用户信息", notes = "根据url的id来指定删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @DeleteMapping("/deleteAccountById/{id}")
    public String deleteAccountById(@PathVariable Integer id) {
        accountMap.remove(id);
        return "success";
    }

    /**
     * @return
     * @ApiIgnore :使用该注解忽略这个API
     */
    @ApiIgnore
    @GetMapping("/ignoreTest")
    public String ignoreTest() {
        return "ignore api test !";
    }
}
