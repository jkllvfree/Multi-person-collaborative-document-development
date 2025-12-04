package com.example.db_document.controller;

import com.example.db_document.model.dto.FolderCreateRequest;
import com.example.db_document.pojo.Folder;
import com.example.db_document.pojo.JsonResult;
import com.example.db_document.servcie.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/folder")
public class FolderController {
    @Autowired
    private FolderService folderService;

    @PostMapping("/create")
    public JsonResult<Folder> createFolder(@RequestBody FolderCreateRequest req,
                                           @RequestHeader("creator_id") Long creatorId ){
        try{
            Folder folder =  folderService.createFolder(req.getName(), creatorId, req.getParentId());
            return JsonResult.success(folder);
        }catch(IllegalArgumentException e) {
            return JsonResult.error(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("系统内部错误");
        }
    }

    //可能需要传入userID，判断是否有删除权限
    @DeleteMapping("/delete")
    public JsonResult<Void> deleteFolder(@RequestParam("folderId") Long folderId){
        try{
            folderService.softDeleteFolder(folderId);
            return JsonResult.success(null);
        }catch(IllegalArgumentException e) {
            return JsonResult.error(e.getMessage());
        }
        catch(RuntimeException e) {
            return JsonResult.error(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("系统内部错误");
        }
    }

    @PostMapping("/move")
    public JsonResult<Void> moveFolder(@RequestParam("folderId") Long folderId,
                                     @RequestParam("newParentId") Long newParentId){
        try{
            folderService.moveFolder(folderId, newParentId);
            return JsonResult.success(null);
        }catch(IllegalArgumentException e) {
            return JsonResult.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("系统内部错误");
        }
    }
}
