window.addEventListener('DOMContentLoaded', function() {
    const timerValue = document.getElementById('timer-value');
    const tempoQuiz = document.getElementById('tempo-quiz');
    const form = document.querySelector('form');
    if (timerValue && tempoQuiz) {
        let timeLeft = parseInt(tempoQuiz.value, 10);
        function updateTimer() {
            let min = Math.floor(timeLeft / 60);
            let sec = timeLeft % 60;
            timerValue.textContent = min + ":" + (sec < 10 ? "0" : "") + sec;
            if (timeLeft > 0) {
                timeLeft--;
                setTimeout(updateTimer, 1000);
            } else {
                window.location.href = "/quiz/finito?timeout=true";
            }
        }
        updateTimer();
    }
});