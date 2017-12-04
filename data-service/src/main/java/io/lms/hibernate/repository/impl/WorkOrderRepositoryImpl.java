package io.lms.hibernate.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.lms.hibernate.repository.WorkOrderRepository;
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
 * Creation date: Jan 26, 2017
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
@Repository("workOrderRepository")
public class WorkOrderRepositoryImpl extends AbstractRepositoryImpl<Integer, KinesisMessage>
		implements WorkOrderRepository {

	private static String collectionName = "workOrder_translog";

	@Override
	public void saveWorkOrder(KinesisMessage<WorkOrder> workOrder) {
		// getMongoOperations().save(workOrder, getCollectionName());
		persistToMongo(workOrder);
	}

	@Override
	public void updateWorkOrder(KinesisMessage<WorkOrder> workOrder) {
		persistToMongo(workOrder);
	}

	@Override
	public List<KinesisMessage> getWorkOrdersForProcessing() {
		return getEntityForProcessing();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.lms.hibernate.repository.AbstractRepository#getCollectionName()
	 */
	@Override
	public String getCollectionName() {
		return collectionName;
	}
}
