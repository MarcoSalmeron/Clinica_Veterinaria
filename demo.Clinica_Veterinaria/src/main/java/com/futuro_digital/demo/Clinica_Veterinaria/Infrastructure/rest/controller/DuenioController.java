package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller;

import com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.in.Duenio.*;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.DuenioRequest;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.DuenioResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/duenio")
public class DuenioController {

    /**
     * Dependencias:
     * El Controlador solo delega las solicitudes http a los endpoints con puertos de entrada: "UseCase" correspondiente
     */
    private final CreateDuenioUseCase createDuenioUseCase;

    private final ListAllDueniosUseCase listAllDueniosUseCase;

    private final FindDuenioUseCase findDuenioUseCase;

    private final UpdateDuenioUseCase updateDuenioUseCase;

    private final DeleteDuenioUseCase deleteDuenioUseCase;

    @GetMapping("/all")
    public ResponseEntity<List<DuenioResponse>> all(){
        log.info("Ejecutando Endpoint /api/v1/duenio/all !");
        return ResponseEntity.ok(listAllDueniosUseCase.getListOfDuenios());
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<DuenioResponse> find(@PathVariable Long id){
        log.info("Ejecutando Endpoint /api/v1/duenio/find/"+id+" !");
        return ResponseEntity.ok(findDuenioUseCase.findDuenio(id));
    }

    @GetMapping("/find/email/{email}")
    public ResponseEntity<DuenioResponse> find(@PathVariable String email){
        log.info("Ejecutando Endpoint /api/v1/duenio/find/email/"+email+" !");
        return ResponseEntity.ok(findDuenioUseCase.findDuenio(email));
    }

    @PostMapping("/save")
    public ResponseEntity<DuenioResponse> save(@RequestBody @Valid DuenioRequest request){
        log.info("Ejecutando Endpoint /api/v1/duenio/save !");
        return ResponseEntity.ok(createDuenioUseCase.createDuenio(request));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DuenioResponse> update(@RequestBody @Valid DuenioRequest request, @PathVariable Long id){
        log.info("Ejecutando Endpoint /api/v1/duenio/update/"+id+" !");
        return ResponseEntity.ok(updateDuenioUseCase.updateDuenio(request,id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        log.info("Ejecutando Endpoint /api/v1/duenio/delete/"+id+" !");
        deleteDuenioUseCase.deleteDuenio(id);
        return ResponseEntity.ok("Dueño eliminado correctamente");
    }
}
