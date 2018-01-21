package org.jugru.monkeyStatistics.api;

import org.jugru.monkeyStatistics.service.SurveyService;
import org.jugru.monkeyStatistics.service.impl.SurveyMonkeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Для разовой настройки
 * и отладки
 */
@RestController
public class ProjectsSystem {
    Logger logger = LoggerFactory.getLogger(ProjectsSystem.class);

    @Autowired
    SurveyMonkeyService surveyMonkeyService;

    @Autowired
    SurveyService surveyService;

    @RequestMapping(value = "/system/update/all")
    public void update() {
        logger.debug("\"/system/update/all\"");
        surveyMonkeyService.updateAll();
    }

    @RequestMapping(value = "/system/delete/all")
    public void delete() {
        logger.debug("\"/system/delete/all\"");
        surveyService.getAll().forEach(surveyService::delete);
    }
}
