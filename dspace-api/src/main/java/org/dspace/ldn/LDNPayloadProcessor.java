package org.dspace.ldn;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.dspace.authorize.AuthorizeException;
import org.dspace.core.Context;

public abstract class LDNPayloadProcessor {
	/** Logger */
	protected static Logger logger = Logger.getLogger(LDNPayloadProcessor.class);
	private List<LDNAction> ldnActions;

	public List<LDNAction> getLdnActions() {
		return ldnActions;
	}

	public void setLdnActions(List<LDNAction> ldnActions) {
		this.ldnActions = ldnActions;
	}

	protected abstract void processLDNPayload(NotifyLDNDTO ldnRequestDTO, Context context)
			throws IllegalStateException, SQLException, AuthorizeException;

	public final void processRequest(NotifyLDNDTO ldnRequestDTO) {

		Context context = null;
		try {
			context = new Context();
			context.turnOffAuthorisationSystem();
			processLDNPayload(ldnRequestDTO, context);
			context.commit();
			
			ActionStatus operation;
			if (ldnActions != null) {
				for (LDNAction action : ldnActions) {
					operation = action.executeAction(context, ldnRequestDTO);
					context.commit();
					if (operation == ActionStatus.ABORT) {
						break;
					}
				}
			}
		} catch (Exception e) {
			logger.error(ldnRequestDTO.toString(), e);
		} finally {
			// Abort the context if it's still valid
			if ((context != null) && context.isValid()) {
				context.restoreAuthSystemState();
				context.abort();
			}
		}
	}

	protected abstract String generateMetadataValue(NotifyLDNDTO ldnRequestDTO);
}