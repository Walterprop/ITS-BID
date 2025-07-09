document.addEventListener('DOMContentLoaded', function() {
    const playBtn = document.getElementById('play-btn');
    const transition = document.getElementById('transition');
    const mainContainer = document.getElementById('main-container');
    const transitionImg = document.querySelector('.transition-img');

    playBtn.addEventListener('click', function() {
        mainContainer.style.display = 'none';
        transition.classList.remove('transition-hidden');
        transitionImg.classList.remove('transition-zoom'); // reset se serve

        // Avvia l'effetto zoom e fade
        setTimeout(() => {
            transitionImg.classList.add('transition-zoom');
        }, 100); // piccolo delay per triggerare la transizione

        // Dopo la durata della transizione, vai alla pagina successiva
        setTimeout(() => {
            window.location.href = '/modalita';
        }, 2100); // deve essere leggermente più lungo della durata della transizione
    });
});