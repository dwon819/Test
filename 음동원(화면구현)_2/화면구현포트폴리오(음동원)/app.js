
	// 문제 객체
	function Question(text, choice, answer){
		this.text = text;
		this.choice = choice;
		this.answer = answer;
	}

	// 퀴즈 정보 객체
	function Quiz(questions){
		this.questions = questions;
		this.score = 0;
		this.questionIndex = 0;
	}

	// 정답 확인 메소드
	Quiz.prototype.correctAnswer = function(answer){
		return answer == this.questions[this.questionIndex].answer;
	};

	// -----------------------------------------------------------------------------------
	// 문제 데이터
	var questions = [
		new Question('다음 중 최초의 웹 브라우저는?',['모자이크','인터넷익스플로어','구글 크롬','넷스케이프 네비게이터'],'넷스케이프 네비게이터'),
		new Question('웹 문서에서 스타일을 작성하는 언어는?', ['HTML', 'jQuery', 'CSS', 'XML'], 'CSS'),
		new Question('명령어 기반의 인퍼페이스를 의미하는 용어는?', ['GUI', 'CLI', 'HUD', 'SI'], 'CLI'),
		new Question('CSS 속성 중 글자의 굵기를 변경하는 속성은?', ['font-size', 'font-style', 'font-weight', 'font-variant'], 'font-weight')
	];

	// 퀴즈 객체 생성
	var quiz = new Quiz(questions);

	// -----------------------------------------------------------------------------------
	// 문제 출력 함수
	function update_quiz(){
		var question = document.getElementById('question');
    	var idx = quiz.questionIndex + 1;
    	var choice = document.querySelectorAll('.btn');//속성이 클레스인 모두를 가져옴
    
    	question.innerHTML = '문제'+idx+") " + quiz.questions[quiz.questionIndex].text;//일반 태그는 innerHTML 폼태그는 value
    
    	for(i=0;i<4;i++){
        	choice[i].innerHTML = quiz.questions[quiz.questionIndex].choice[i];
    	}
    	progress();
	}


	// 문제 진행 정보 표시(현재 문제 번호/총 문항수)
	function progress(){
		var total_idx = document.getElementById('progress');
		total_idx.innerHTML = '문제 '+(quiz.questionIndex+1)+' / '+quiz.questions.length;
	}


	// -----------------------------------------------------------------------------------	
	// 결과 표시
	function result(){
		var quiz_div = document.getElementById('quiz');
		var per = parseInt((quiz.score*100)/quiz.questions.length);
		var txt = '<h1>결과</h1>'+
						'<h2 id="score">당신의 점수: '+quiz.score+' / '+
						quiz.questions.length+'<br><br>' + per + '점</h2>';
		quiz_div.innerHTML = txt;

    	if(per >= 80){
			txt += '<h2 style="color:red">훌륭합니다</h2>';
			quiz_div.innerHTML = txt;
   		}
	} 


	// -----------------------------------------------------------------------------------
	var btn = document.querySelectorAll('.btn');	// .btn 객체

	// 입력 및 정답 확인 함수
	function checkAnswer(i){
		btn[i].addEventListener('click',function(){
			
			var answer = btn[i].innerText;//문자값 읽어오기
			if(quiz.correctAnswer(answer)){
				alert("정답입니다.");
				quiz.score++;
				console.log(btn[i].innerText);
			}else{
				alert("틀렸습니다.");
			}
			if(quiz.questionIndex < quiz.questions.length-1){
				quiz.questionIndex++;
				update_quiz();
			}else{
				result();
			}
			
		});
	}

	// 4개의 버튼 이벤트리스너 지정
	for(var i = 0; i < btn.length; i++){
		checkAnswer(i);
	}

	function result(){
		var quiz_div = document.getElementById('quiz');
		var per = parseInt((quiz.score*100)/quiz.questions.length);
		var txt = '<h1>결과</h1>'+
						'<h2 id="score">당신의 점수: '+quiz.score+' / '+
						quiz.questions.length+'<br><br>' + per + '점</h2>';
		quiz_div.innerHTML = txt;
	
		if(per >= 80){
			txt += '<h2 style="color:red">훌륭합니다</h2>';
			quiz_div.innerHTML = txt;
		}else if(per<80 && per >= 60){
			txt += '<h2 style="color:red">무난한 점수네요</h2>';
			quiz_div.innerHTML = txt;
		}else{
			txt += '<h2 style="color:red">좀 더 분발하세요</h2>';
			quiz_div.innerHTML = txt;
		}
	}
	

	update_quiz();


