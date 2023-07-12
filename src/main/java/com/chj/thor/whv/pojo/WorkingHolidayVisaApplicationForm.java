package com.chj.thor.whv.pojo;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

/**
 * @author: wanglianhai@lixiang.com
 * @date: 2023/7/7 16:42
 */
@Data
public class WorkingHolidayVisaApplicationForm {
    private String username;
    private String password;

    private String familyName;
    private String givenName1;
    private String givenName2;
    private String givenName3;
    private String otherName;

    private String gender;
    private String dateOfBirth;
    private String countryOfBirth;

    private String streetNumber;
    private String streetName;
    private String suburb;
    private String city;
    private String provinceState;
    private String zipCode;
    private String country;

    private String phoneDaytime;
    private String phoneNight;
    private String phoneMobile;
    private String fax;
    private String email;
    private String represented;
    private String communicationMethod = "Email";
    private String creditCard = "Yes";


    private String passportNumber;
    private String passportExpireDate;
    private String identificationType;
    private String dateDocumentIssued;
    private String expireDateOfDocument;

    private String intendTravelDate;

    private String payerName;


    private String cardNumber = "4485445019253882";
    private String cardExpiryDate = "03/25";
    private String cardVerificationCode = "675";
    private String cardholder = "cardholder";

    private String applyUrl = "https://onlineservices.immigration.govt.nz/WorkingHoliday/Application/Create.aspx?CountryId=24&OffShore=1&STZ=0";
//    private String applyUrl = "https://onlineservices.immigration.govt.nz/WorkingHoliday/Application/Create.aspx?CountryId=46&OffShore=1&STZ=0";
}
