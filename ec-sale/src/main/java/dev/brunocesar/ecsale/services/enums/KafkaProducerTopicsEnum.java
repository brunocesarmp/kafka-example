package dev.brunocesar.ecsale.services.enums;

public enum KafkaProducerTopicsEnum {

	SALE("sale");

	String value;

	KafkaProducerTopicsEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
