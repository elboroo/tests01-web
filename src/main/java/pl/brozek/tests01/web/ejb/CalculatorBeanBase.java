package pl.brozek.tests01.web.ejb;

import java.security.Principal;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TimerService;
import pl.brozek.tests01.web.exceptions.CheckedException;
import pl.brozek.tests01.web.exceptions.UncheckedException;

/**
 *
 * @author Bogus
 */
@Stateless
@LocalBean
public class CalculatorBeanBase implements CalculatorCommonBusiness {

    @Resource
    private SessionContext sessionContext;

    @PostConstruct
    private void init() throws UncheckedException {

    }

    @PreDestroy
    private void destroy() throws CheckedException { // todo sprawdzić w działaniu bo podobno ma być unchecked

    }

    /**
     * {@link CalculatorCommonBusiness#add(int...) }
     */
    @Override
    public int add(int... arguments) {
        int result = 0;

        CalculatorCommonBusiness _this = sessionContext.getBusinessObject(CalculatorCommonBusiness.class);
        Class invokedBusinessInterface = sessionContext.getInvokedBusinessInterface();
        TimerService timerService = sessionContext.getTimerService();
        Principal callerPrincipal = sessionContext.getCallerPrincipal();
        boolean isCallerInRole = sessionContext.isCallerInRole("ROLE1");

        for (int argument : arguments) {
            result += argument;
        }
        return result;
    }

}
