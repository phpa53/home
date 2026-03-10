package com.st.home.jsf;

import java.io.Serializable;

import com.st.home.uti.AppContext;
import com.st.home.uti.AppProperties;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Named
@ViewScoped
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class HomeBean implements Serializable {

	private static final long serialVersionUID = -4670991962647880888L;
	private String appLabel;
	private String appVersion;
	private String appEnv;
	private String userName;
	private String keycloakUrl;
	private String homeUrl;
	private String fsmUrl;
	private String elithoUrl;
	private String qlithoUrl;

	@PostConstruct
	public void init() {

	    this.appLabel = AppProperties.getAppLabel();
	    this.appVersion = AppProperties.getAppVersion();
	    this.appEnv = AppProperties.APP_ENV;
		this.userName = AppContext.getUserName();
	    this.keycloakUrl = AppProperties.KEYCLOAK_URL;
	    this.homeUrl = AppProperties.HOME_URL;
	    this.fsmUrl = AppProperties.FSM_URL;
	    this.elithoUrl = AppProperties.ELITHO_URL;
	    this.qlithoUrl = AppProperties.QLITHO_URL;

	}

	public String getFsmTabUrl(final int tab) {
		return String.format("%s/index.xhtml?tab=%d", this.fsmUrl, tab);
		//LoggerWrapper.info(log, String.format("Redirect to %s", url));
	}

}
