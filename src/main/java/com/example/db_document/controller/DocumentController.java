package com.example.db_document.controller;

import com.example.db_document.model.dto.DocumentCreateRequest;
import com.example.db_document.pojo.Document;
import com.example.db_document.pojo.JsonResult;
import com.example.db_document.servcie.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    public DocumentController(){
    }

    @PostMapping("/create")
    public JsonResult<Document> createDocument(@RequestBody DocumentCreateRequest req,
                                               @RequestHeader("creator_id") Long creatorId ){
        try{
            Document folder =  documentService.createDocument(req.getName(), req.getFolderId(), req.getContent(), creatorId);
            return JsonResult.success(folder);
        }catch(IllegalArgumentException e) {
            return JsonResult.error(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("系统内部错误");
        }
    }

    @DeleteMapping("/delete")
    public JsonResult<Void> deleteDocument (@RequestParam("documentId") Long documentId){
        try{
            documentService.softDeleteDocument(documentId);
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
    public JsonResult<Void> moveDocument(@RequestParam("documentId") Long documentId,
                                      @RequestParam("newFolderId") Long newFolderId) {
        try {
            documentService.moveDocument(documentId, newFolderId);
            return JsonResult.success(null);
        } catch (IllegalArgumentException e) {
            return JsonResult.error(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("系统内部错误");
        }
    }
}
