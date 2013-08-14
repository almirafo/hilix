package br.com.supportcomm.freecall.service.operationlog;

import br.com.supportcomm.freecall.entity.Operationlog;
import br.com.supportcomm.freecall.impl.operationlog.OperationlogBean;
import br.com.supportcomm.freecall.impl.operationlog.OperationlogBeanLocal;

/**
 * Session Bean implementation class ScheduleService
 */
public class OperationlogService {

    /**
     * Default constructor. 
     */
    public OperationlogService() {
    }
    
    private OperationlogBeanLocal operationlogBean = new OperationlogBean();
	
	public Operationlog persistSchedule(Operationlog operationlog) {
		return operationlogBean.persistOperationlog(operationlog);
	}

		
}


