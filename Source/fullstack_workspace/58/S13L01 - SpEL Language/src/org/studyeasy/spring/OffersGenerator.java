package org.studyeasy.spring;

public class OffersGenerator {
   String offerIND,OfferUS;

public OffersGenerator() {
	this.offerIND = "No Current offers in India";
	this.OfferUS = "No Current offers in USA";
}

public String getOfferIND() {
	return offerIND;
}

public String getOfferUS() {
	return OfferUS;
}

}
