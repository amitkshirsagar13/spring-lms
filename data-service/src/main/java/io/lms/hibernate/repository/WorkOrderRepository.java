package io.lms.hibernate.repository;

import java.util.List;

import io.lms.model.KinesisMessage;
import io.lms.model.workorder.WorkOrder;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName DatasyncMicroService
 * &#64;class IdentityRepository
 * Creation date: Jan 30, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public interface WorkOrderRepository extends AbstractRepository {

	public void saveWorkOrder(KinesisMessage<WorkOrder> workOrder);

	public void updateWorkOrder(KinesisMessage<WorkOrder> workOrder);

	public List<KinesisMessage> getWorkOrdersForProcessing();
}
