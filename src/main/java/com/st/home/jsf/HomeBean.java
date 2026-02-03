package com.st.home.jsf;

import java.io.Serializable;

import com.st.home.uti.AppContext;
import com.st.home.uti.AppProperties;
import com.st.home.uti.LoggerWrapper;

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
	private String userName;
	private String keycloakUrl;
	private String homeUrl;
	private String appLabel;
	private String appVersion;
	private String fsmUrl;

	@PostConstruct
	public void init() {

		this.userName = AppContext.getUserName();
	    this.homeUrl = AppProperties.HOME_URL;
	    this.keycloakUrl = AppProperties.KEYCLOAK_URL;
	    this.appLabel = AppProperties.getAppLabel();
	    this.appVersion = AppProperties.getAppVersion();
	    this.fsmUrl = AppProperties.FSM_URL;

	}

	public String getFsmTabUrl(final int tab) {

		final var url = String.format("%s/index.xhtml?tab=%d", this.fsmUrl, tab);

		LoggerWrapper.info(log, String.format("Redirect to %s", url));

		return url;

	}

}
