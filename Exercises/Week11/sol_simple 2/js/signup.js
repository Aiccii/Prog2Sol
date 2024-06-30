import * as signout from "./signout.js"
import {checkDateOfBirth} from "./checkDates.js";

const usernameElement = document.getElementById('username');
const dobElement = document.getElementById('dob');
const passwordElement = document.getElementById('password');
const confirmPasswordElement = document.getElementById('confirm_password');
const agreeElement = document.getElementById('agree');

const signupElement = document.getElementById('signup');

passwordElement.addEventListener('input', updatePasswordStrength);
signupElement.addEventListener('click', submitForm);

const passwordStrengthClasses = ['pass_very_weak', 'pass_weak', 'pass_ok', 'pass_strong'];

function updatePasswordStrength() {
    /**
     * @type {String}
     */
    const userPassword = passwordElement.value;

    let strength = 0;

    // Password length
    if (userPassword.length > 5) {
        strength++;
    }

    // Mix of upper case and lower case
    if (userPassword.toUpperCase() !== userPassword && userPassword.toLowerCase() !== userPassword) {
        strength++;
    }

    // Contains a digit?
    if (userPassword.match(/\d/)) {
        strength++;
    }

    // Punctuation? (just these are fine, no need to list every possible char here...)
    if (userPassword.match(/[.,:;]/)) {
        strength++;
    }

    const buttons = document.querySelectorAll('.strength-meter > button');
    const cssClassForCurrentPassword = passwordStrengthClasses[strength - 1];
    for (let i = 0; i < buttons.length; i++) {
        const button = buttons[i];
        button.classList.remove(...passwordStrengthClasses);
        if (strength > i) {
            button.classList.add(cssClassForCurrentPassword);
        }
    }
}

function addErrorMessage(errorMessageElement, message) {
    if (errorMessageElement.firstElementChild.textContent) {
        errorMessageElement.firstElementChild.textContent += ' ' + message;
    } else {
        errorMessageElement.firstElementChild.textContent = message;
    }
}

function showHideErrorMessages(errorMessageElement) {
    if (errorMessageElement.firstElementChild.textContent) {
        errorMessageElement.style.visibility = 'visible';
    } else {
        errorMessageElement.style.visibility = 'hidden';
    }
}

function submitForm() {
    /**
     * @type {HTMLElement}
     */
    const errorMessageElementUsername = usernameElement.parentElement.querySelector('.text-danger');
    errorMessageElementUsername.firstElementChild.textContent = null;
    /**
     * @type {HTMLElement}
     */
    const errorMessageElementDOB = dobElement.parentElement.querySelector('.text-danger');
    errorMessageElementDOB.firstElementChild.textContent = null;
    /**
     * @type {HTMLElement}
     */
    const errorMessageElementPassword = passwordElement.parentElement.querySelector('.text-danger');
    errorMessageElementPassword.firstElementChild.textContent = null;
    /**
     * @type {HTMLElement}
     */
    const errorMessageElementConfirmPassword = confirmPasswordElement.parentElement.querySelector('.text-danger');
    errorMessageElementConfirmPassword.firstElementChild.textContent = null;
    /**
     * @type {HTMLElement}
     */
    const errorMessageElementAgree = agreeElement.parentElement.querySelector('.text-danger');
    errorMessageElementAgree.firstElementChild.textContent = null;

    let formOk = true;

    /**
     * Checks for username.
     */
    if (!usernameElement.value) {
        addErrorMessage(errorMessageElementUsername, 'Please choose a username.');
        formOk = false;
    }
    if (usernameElement.value && usernameElement.length < 4) {
        addErrorMessage(errorMessageElementUsername, 'Username should be at least length 4.');
        formOk = false;
    }
    if (usernameElement.value && !usernameElement.value.match(/^[a-zA-Z][a-zA-Z0-9]{3,}$/)) {
        addErrorMessage(errorMessageElementUsername, 'Username should start with a letter and contain only letters and/or digits.');
        formOk = false;
    }
    showHideErrorMessages(errorMessageElementUsername);

    /**
     * Checks for date of birth.
     */
    try{
      checkDateOfBirth(dobElement.value)
    } catch(error){
      addErrorMessage(errorMessageElementDOB, error.message);
    }
    showHideErrorMessages(errorMessageElementDOB);

    /**
     * Check for password.
     */
    if (!passwordElement.value) {
        addErrorMessage(errorMessageElementPassword, 'You must enter a password.');
        formOk = false;
    }
    showHideErrorMessages(errorMessageElementPassword);

    /**
     * Check for password confirmation.
     */
    if (!confirmPasswordElement.value || confirmPasswordElement.value !== passwordElement.value) {
        addErrorMessage(errorMessageElementConfirmPassword, 'Both passwords must match.');
        formOk = false;
    }
    showHideErrorMessages(errorMessageElementConfirmPassword);

    /**
     * Check for agreement.
     */
    if (!agreeElement.checked) {
        addErrorMessage(errorMessageElementAgree, 'You must agree with everything.');
        formOk = false;
    }
    showHideErrorMessages(errorMessageElementAgree);

    if (formOk) {
        localStorage.setItem('SIGNED_IN_AS', usernameElement.value);
        document.forms[0].submit();
    }
}
