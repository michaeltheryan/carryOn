window.addEventListener("load", (event) => {
    let titleElement = document.querySelector("title");
    let title = titleElement.textContent;
    let navigationElements = ['carryOn!', '[User Profile - name to be automatically generated]',
        'Create Account', 'Signin or Create Account link'];
    let navigationText = ['Home', 'Profile', 'Registration', 'Sign In'];
    let navigationLinks = ['home.html', 'profile.html', 'registration.html', 'signin.html'];
    let destinationElement = document.getElementById('navbar');
    let titlePlacement = navigationElements.lastIndexOf(title);
    if (titlePlacement >= 0) {
        for (let i = 0; i < navigationElements.length; i++) {
            if (i == titlePlacement) {
                continue;
            }
            let anchorInsert = document.createElement('a');
            anchorInsert.href = navigationLinks[i];
            anchorInsert.textContent = navigationText[i];
            destinationElement.appendChild(anchorInsert);
        }
    }
});
