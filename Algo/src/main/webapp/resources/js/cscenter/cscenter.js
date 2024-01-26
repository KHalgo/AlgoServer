window.onload = () => {
    document.querySelectorAll('.toggleButton').forEach(function(button) {
        button.addEventListener('click', function() {
            var targetId = this.getAttribute('data-target');
            var targetElement = document.getElementById(targetId);
            
            if (targetElement) {
                // 요소가 존재하는 경우에만 스타일을 변경
                if (targetElement.style.display === "none" || targetElement.style.display === "") {
                    targetElement.style.display = "table-row";
                } else {
                    targetElement.style.display = "none";
                }
            }
        });
    });
}
