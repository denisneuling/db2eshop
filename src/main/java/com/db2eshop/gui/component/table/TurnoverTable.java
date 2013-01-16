package com.db2eshop.gui.component.table;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.annotations.bindings.UIFor;
import com.db2eshop.governance.service.model.TurnoverService;
import com.db2eshop.gui.component.table.api.GenericTable;
import com.db2eshop.model.Turnover;

/**
 * <p>TurnoverTable class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@UIFor(Turnover.class)
@Component
public class TurnoverTable extends GenericTable<Turnover>{
	private static final long serialVersionUID = 7368521561280743848L;
	protected Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private TurnoverService turnoverService;
	
	/** {@inheritDoc} */
	@Override
	public void onApplicationReady() {
		this.ready = false;
	}
	
	/**
	 * <p>setup.</p>
	 */
	public void setup(){
		List<Turnover> turnovers = turnoverService.loadEntireTable();
		for(Turnover turnover : turnovers){
			addRow(turnover);
		}
		this.ready = true;
	}
	
	/**
	 * <p>destroy.</p>
	 */
	public void destroy(){
		this.ready = false;
		((DefaultTableModel)this.getModel()).setRowCount(0);
	}
	
	/** {@inheritDoc} */
	@Override
	public void onRowChange(Turnover entity) {
		turnoverService.update(entity);
	}
	/** {@inheritDoc} */
	@Override
	public void onRowRemove(Turnover entity) {
		turnoverService.delete(entity);
	}
	
	/** {@inheritDoc} */
	@Override
	public void onRowAdd(Turnover entity) {
		turnoverService.save(entity);
	}
	
	/** {@inheritDoc} */
	@Override
	public void onError(Throwable throwable) {
		errorDialog.showError(onConstraintViolation(throwable),throwable);
	}
	
	/** {@inheritDoc} */
	public boolean isCellEditable(int row, int column) {
		return false;
	}
}
