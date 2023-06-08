package com.dzydowicz.meteoritelandings.controller;

import com.dzydowicz.meteoritelandings.converters.MeteoriteLandingTOsConverter;
import com.dzydowicz.meteoritelandings.db.repository.MeteoriteLandingsService;
import com.dzydowicz.meteoritelandings.models.MeteoriteLandingTO;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingFallEnum;
import com.dzydowicz.meteoritelandings.models.enums.MeteoriteLandingNameTypeEnum;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingCreationTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingFilterTO;
import com.dzydowicz.meteoritelandings.tos.MeteoriteLandingUpdateTO;
import com.dzydowicz.meteoritelandings.tos.create.MeteoriteLandingCreationRequestTO;
import com.dzydowicz.meteoritelandings.tos.create.MeteoriteLandingMultiCreationRequestTO;
import com.dzydowicz.meteoritelandings.tos.update.MeteoriteLandingUpdateRequestTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/meteorite-landings", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MeteoriteLandingsController {
    private final MeteoriteLandingsService meteoriteLandingsService;

    @GetMapping("/{id}")
    public ResponseEntity<MeteoriteLandingTO> getMeteoriteLanding(@PathVariable int id) {
        MeteoriteLandingTO meteoriteLanding = meteoriteLandingsService.findMeteoriteLanding(id);
        return new ResponseEntity<>(meteoriteLanding, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MeteoriteLandingTO>> getMeteoriteLandings(@RequestParam(value = "ids", required = false) List<Integer> ids,
                                                         @RequestParam(value = "nameType", required = false) MeteoriteLandingNameTypeEnum nameType,
                                                         @RequestParam(value = "fall", required = false) MeteoriteLandingFallEnum fall,
                                                         @RequestParam(value = "minMass", required = false) Float minMass,
                                                         @RequestParam(value = "maxMass", required = false) Float maxMass,
                                                         @RequestParam(value = "minYear", required = false) Integer minYear,
                                                         @RequestParam(value = "maxYear", required = false) Integer maxYear) {
        MeteoriteLandingFilterTO meteoriteLandingFilterTO = new MeteoriteLandingFilterTO(ids, nameType, fall, minMass, maxMass, minYear, maxYear);
        List<MeteoriteLandingTO> meteoriteLandingTOs = meteoriteLandingsService.getFilteredMeteoriteLandings(meteoriteLandingFilterTO);

        return new ResponseEntity<>(meteoriteLandingTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MeteoriteLandingTO> createMeteoriteLanding(@RequestBody MeteoriteLandingCreationRequestTO requestTO) {
        MeteoriteLandingCreationTO meteoriteLandingCreationTO = MeteoriteLandingTOsConverter.convertToMeteoriteLandingCreationTO(requestTO);
        return new ResponseEntity<>(meteoriteLandingsService.createMeteoriteLanding(meteoriteLandingCreationTO), HttpStatus.OK);
    }

    @PostMapping("/multi-create")
    public ResponseEntity<List<MeteoriteLandingTO>> createMultiMeteoriteLandings(@RequestBody MeteoriteLandingMultiCreationRequestTO requestTO) {
        List<MeteoriteLandingCreationTO> meteoriteLandingCreationTOs = requestTO.getMeteoriteLandings().stream()
                .map(MeteoriteLandingTOsConverter::convertToMeteoriteLandingCreationTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(meteoriteLandingsService.createMultipleMeteoriteLandings(meteoriteLandingCreationTOs), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MeteoriteLandingTO> updateMeteoriteLanding(@PathVariable int id, @RequestBody MeteoriteLandingUpdateRequestTO requestTO) {
        MeteoriteLandingUpdateTO meteoriteLandingCreationTO = MeteoriteLandingTOsConverter.convertToMeteoriteLandingUpdateTO(requestTO);
        MeteoriteLandingTO meteoriteLandingTO = meteoriteLandingsService.updateMeteoriteLanding(id, meteoriteLandingCreationTO);

        return new ResponseEntity<>(meteoriteLandingTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeMeteoriteLanding(@PathVariable int id) {
        meteoriteLandingsService.removeMeteoriteLanding(id);
        return new ResponseEntity<>("Meteorite landing with id " + id + "correctly removed.", HttpStatus.OK);
    }
}
