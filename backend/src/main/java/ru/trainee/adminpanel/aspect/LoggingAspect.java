package ru.trainee.adminpanel.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.trainee.adminpanel.data.model.Action;
import ru.trainee.adminpanel.data.model.Banner;
import ru.trainee.adminpanel.data.model.User;
import ru.trainee.adminpanel.service.Authentication;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution(* ru.trainee.adminpanel.service.BannerService.saveBanner(..)) && args(banner)")
    public Object LogSaveBanner(JoinPoint joinPoint, Banner banner) throws Throwable {
        Authentication authentication = new Authentication();
        User admin = authentication.getUserFromAuthentication();

        logger.log(Level.INFO, joinPoint.getSignature() + " Add new banner: " + banner + " by " + admin.getLogin() + "...");
        return banner;
    }

    @Before("execution(* ru.trainee.adminpanel.service.BannerService.editBanner(..)) && args(banner)")
    public Object LogEditBanner(JoinPoint joinPoint, Banner banner) throws Throwable {
        Authentication authentication = new Authentication();
        User admin = authentication.getUserFromAuthentication();

        logger.log(Level.INFO, joinPoint.getSignature() + " Update banner: " + banner + " by " + admin.getLogin() + "...");
        return banner;
    }

    @Before("execution(* ru.trainee.adminpanel.service.BannerService.deleteBanner(..)) && args(bannerId)")
    public Object LogDeleteBanner(JoinPoint joinPoint, Long bannerId) throws Throwable {
        Authentication authentication = new Authentication();
        User admin = authentication.getUserFromAuthentication();

        logger.log(Level.INFO, joinPoint.getSignature() + " Delete banner with id:" + bannerId + " by " + admin.getLogin() + "...");
        return bannerId;
    }

    @Before("execution(void ru.trainee.adminpanel.service.ActionService.saveAction(..)) && args(action)")
    public Object LogAddAction(JoinPoint joinPoint, Action action) throws Throwable {
        Authentication authentication = new Authentication();
        User admin = authentication.getUserFromAuthentication();

        logger.log(Level.INFO, joinPoint.getSignature() + " Add action: " + action + " by " + admin.getLogin() + "...");
        return action;
    }
}