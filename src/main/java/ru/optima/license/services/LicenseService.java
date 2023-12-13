package ru.optima.license.services;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.optima.license.model.License;

import java.util.Locale;
import java.util.Random;

@Service
public class LicenseService {

    private final MessageSource messageSource;

    public LicenseService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public License getLicense(String licenseId, String organizationId){
        License license = new License();
        license.setId(new Random().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("DemoAIS");
        license.setLicenseType("full");
        return license;
    }

    public String createLicense(License license, String organizationId, Locale locale){
        String responceMessage = null;
        if (license != null){
            license.setOrganizationId(organizationId);
            responceMessage = String.format(messageSource.getMessage("license.create.message", null, locale), license.toString());
        }
        return responceMessage;
    }

    public String updateLicense(License license, String organizationId, Locale locale){
        String responceMessage = null;
        if (license != null){
            license.setOrganizationId(organizationId);
            responceMessage = String.format(messageSource.getMessage("license.update.message", null, locale), license.toString());
        }
        return responceMessage;
    }

    public String deleteLicense(String licenseId, String organizationId, Locale locale){
        return String.format(messageSource.getMessage("license.delete.message", null, locale), licenseId, organizationId);
    }

}
