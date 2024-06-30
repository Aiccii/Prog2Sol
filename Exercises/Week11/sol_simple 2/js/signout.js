const signoutDiv = document.getElementById('navbarSignout');
const signinDiv = document.getElementById('navbarSignin');
const usernameSpan = document.querySelector('#navbarSignout span');
const signoutButton = document.getElementById('signout');

signoutButton.addEventListener('click', signOut);

function signOut() {
    localStorage.removeItem('SIGNED_IN_AS');

    updateSignInStatus();
}

function updateSignInStatus() {
    const username = localStorage.getItem('SIGNED_IN_AS');
    signoutDiv.style.display = username ? 'block' : 'none';
    signinDiv.style.display = username ? 'none' : 'block';
    if (username) {
        usernameSpan.innerText = `Logged in as ${username}.`;
    }
}

updateSignInStatus();
