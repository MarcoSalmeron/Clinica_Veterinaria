package com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller;

import com.futuro_digital.demo.Clinica_Veterinaria.Application.ports.in.Mascota.*;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascoDuenioResponse;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascotaRequest;
import com.futuro_digital.demo.Clinica_Veterinaria.Infrastructure.rest.controller.dto.MascotaResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/mascota")
public class MascotaController {

    /**
     * Dependencias:
     * El Controlador solo delega las solicitudes http a los endpoints con puerto de entrada: "UseCase" correspondiente
     */
    private final CreateMascotaUseCase createMascotaUseCase;

    private final ListAllMascotasUseCase listAllMascotasUseCase;

    private final FindMascotaUseCase findMascotaUseCase;

    private final UpdateMascotaUseCase updateMascotaUseCase;

    private final DeleteMascotaUseCase deleteMascotaUseCase;

    @GetMapping("/all")
    public ResponseEntity<List<MascotaResponse>> all (){
        log.info("Ejecutando Endpoint /api/v1/mascota/all !");
        return ResponseEntity.ok(listAllMascotasUseCase.getListOfMascotas());
    }

    @GetMapping("/filter/especie/{especie}")
    public ResponseEntity<List<MascotaResponse>> filterByEspecie(@PathVariable String especie){
        log.info("Ejecutando Endpoint /api/v1/mascota/filter/especie/"+especie+" !");
        return ResponseEntity.ok(listAllMascotasUseCase.filterMascotasByEspecie(especie));
    }

    @GetMapping("/filter/raza/{raza}")
    public ResponseEntity<List<MascotaResponse>> filterByRaza(@PathVariable String raza){
        log.info("Ejecutando Endpoint /api/v1/mascota/filter/raza/"+raza+" !");
        return ResponseEntity.ok(listAllMascotasUseCase.filterMascotasByRaza(raza));
    }

    @GetMapping("/find/duenio/{id_duenio}")
    public ResponseEntity<MascotaResponse> filterByDuenio(@PathVariable Long id_duenio){
        log.info("Ejecutando Endpoint /api/v1/mascota/find/duenio/"+id_duenio+" !");
        return ResponseEntity.ok(findMascotaUseCase.findByDuenio(id_duenio));
    }

    @GetMapping("/duenios")
    public ResponseEntity<List<MascoDuenioResponse>> getMascoDuenios(){
        log.info("Ejecutando Endpoint /api/v1/mascota/duenios !");
        return ResponseEntity.ok(listAllMascotasUseCase.getListOfMascoDuenios());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MascotaResponse> find(@PathVariable Long id){
        log.info("Ejecutando Endpoint /api/v1/mascota/find/"+id+" !");
        return ResponseEntity.ok(findMascotaUseCase.findMascota(id));
    }

    @PostMapping("/save/{idDuenio}")
    public ResponseEntity<MascotaResponse> save(@RequestBody @Valid MascotaRequest request, @PathVariable Long idDuenio){
        log.info("Ejecutando Endpoint /api/v1/mascota/save/"+idDuenio+" !");
        return ResponseEntity.ok(createMascotaUseCase.createMascota(request, idDuenio));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MascotaResponse> update(@RequestBody @Valid MascotaRequest request, @PathVariable Long id){
        log.info("Ejecutando Endpoint /api/v1/mascota/update/"+id+" !");
        return ResponseEntity.ok(updateMascotaUseCase.updateMascota(request, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        log.info("Ejecutando Endpoint /api/v1/mascota/delete/"+id+" !");
        deleteMascotaUseCase.deleteMascota(id);
        return ResponseEntity.ok("Mascota eliminada correctamente");
    }
}
