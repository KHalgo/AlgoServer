window.onload = () => {
	 document.getElementById("cscImg").addEventListener("click", function() {
        var answerBox = document.getElementById("answerBox");
        answerBox.style.display = (answerBox.style.display == 'none') ? 'revert' : 'none';
    });
} 