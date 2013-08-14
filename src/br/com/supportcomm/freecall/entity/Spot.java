package br.com.supportcomm.freecall.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Array;


/**
 * The persistent class for the spot database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Spot.All"              , query = "select u from Spot u "),
    @NamedQuery(name = "Spot.AllActive"        , query = "select u from Spot u where u.enableSpot = '1'")
			  })

public class Spot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SPOT_SPOTID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SPOT_SPOTID_GENERATOR")
	@Column(name="spot_id")
	private Long spotId;

	@Column(name="audio_congrat")
	private String audioCongrat;



	@Column(name="audio_help")
	private String audioHelp;


	@Column(name="audio_intro")
	private String audioIntro;



	@Column(name="audio_spot")
	private String audioSpot;



	@Column(name="confirmation_digit")
	private String confirmationDigit;

	@Column(name="enable_spot")
	private String enableSpot;

	@Column(name="spot_name")
	private String spotName;

	@Column(name="url_subscribe_check")
	private String urlSubscribeCheck;

	@Column(name="url_subscribe_hostname")
	private String urlSubscribeHostname;

	@Column(name="url_subscribe_method")
	private String urlSubscribeMethod;

	@Column(name="url_subscribe_param")
	private String urlSubscribeParam;

	@Column(name="url_subscribe_path")
	private String urlSubscribePath;

	@Column(name="url_subscribe_proto")
	private String urlSubscribeProto;

	public Spot() {
	}

	public Long getSpotId() {
		return this.spotId;
	}

	public void setSpotId(Long spotId) {
		this.spotId = spotId;
	}

	public String getAudioCongrat() {
		return this.audioCongrat;
	}

	public void setAudioCongrat(String audioCongrat) {
		this.audioCongrat = audioCongrat;
	}



	public String getAudioHelp() {
		return this.audioHelp;
	}

	public void setAudioHelp(String audioHelp) {
		this.audioHelp = audioHelp;
	}



	public String getAudioIntro() {
		return this.audioIntro;
	}

	public void setAudioIntro(String audioIntro) {
		this.audioIntro = audioIntro;
	}



	public String getAudioSpot() {
		return this.audioSpot;
	}

	public void setAudioSpot(String audioSpot) {
		this.audioSpot = audioSpot;
	}



	public String getConfirmationDigit() {
		return this.confirmationDigit;
	}

	public void setConfirmationDigit(String confirmationDigit) {
		this.confirmationDigit = confirmationDigit;
	}

	public String getEnableSpot() {
		return this.enableSpot;
	}

	public void setEnableSpot(String enableSpot) {
		this.enableSpot = enableSpot;
	}

	public String getSpotName() {
		return this.spotName;
	}

	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}

	public String getUrlSubscribeCheck() {
		return this.urlSubscribeCheck;
	}

	public void setUrlSubscribeCheck(String urlSubscribeCheck) {
		this.urlSubscribeCheck = urlSubscribeCheck;
	}

	public String getUrlSubscribeHostname() {
		return this.urlSubscribeHostname;
	}

	public void setUrlSubscribeHostname(String urlSubscribeHostname) {
		this.urlSubscribeHostname = urlSubscribeHostname;
	}

	public String getUrlSubscribeMethod() {
		return this.urlSubscribeMethod;
	}

	public void setUrlSubscribeMethod(String urlSubscribeMethod) {
		this.urlSubscribeMethod = urlSubscribeMethod;
	}

	public String getUrlSubscribeParam() {
		return this.urlSubscribeParam;
	}

	public void setUrlSubscribeParam(String urlSubscribeParam) {
		this.urlSubscribeParam = urlSubscribeParam;
	}

	public String getUrlSubscribePath() {
		return this.urlSubscribePath;
	}

	public void setUrlSubscribePath(String urlSubscribePath) {
		this.urlSubscribePath = urlSubscribePath;
	}

	public String getUrlSubscribeProto() {
		return this.urlSubscribeProto;
	}

	public void setUrlSubscribeProto(String urlSubscribeProto) {
		this.urlSubscribeProto = urlSubscribeProto;
	}

}