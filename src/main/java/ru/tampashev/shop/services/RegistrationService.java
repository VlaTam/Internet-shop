package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.RegistrationForm;

public interface RegistrationService {

    boolean doRegistration(RegistrationForm registrationForm);
}
