window.onload = () => {
    document.querySelectorAll('.toggleButton').forEach(function(button) {
        button.addEventListener('click', function() {
            var targetId = this.getAttribute('data-target');
            var targetElement = document.getElementById(targetId);

            if (targetElement) {
                // 요소가 존재하는 경우에만 스타일을 변경
                if (targetElement.style.display === "none" || targetElement.style.display === "") {
                    targetElement.style.display = "table-row";

                    // 클릭한 이미지의 부모 행을 찾아서 그 안의 제목을 다시 표시
                    var parentRow = this.closest('tr');
                    if (parentRow) {
                        var titleCell = parentRow.querySelector('.question');
                        if (titleCell) {
                            titleCell.style.display = "table-cell"; // 제목을 다시 표시
                        }
                    }
                } else {
                    targetElement.style.display = "none";
                }
            }
        });
    });

//    let csWritter = document.getElementById('cscenterwritter');
//    if (csWritter) { // csWritter가 존재하는지 확인
//        csWritter.addEventListener('click', function() {
//            window.location.href = "${ path }/cscenter/writter";
//        });
//    }
};
