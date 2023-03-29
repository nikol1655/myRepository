var player1 = "Player 1";

var player2 = "Player 2";

var randomNumber1 = Math.floor(Math.random() * 6) + 1;

var randomDiceImage = "dice" + randomNumber1 + ".png";

var randomImageSource = "images/" + randomDiceImage;

var image1 = document.querySelectorAll("img")[0];

image1.setAttribute("src", randomImageSource);


var randomNumber2 = Math.floor(Math.random() * 6) + 1;

var randomImageSource2 = "images/dice" + randomNumber2 + ".png";

document.querySelectorAll("img")[1].setAttribute("src", randomImageSource2);


if(randomNumber1 > randomNumber2) {
    document.querySelector("h1").innerHTML = player1 + " wins";
} else if (randomNumber1 < randomNumber2) {
    document.querySelector("h1").innerHTML = player2 + " wins";
} else {
    document.querySelector("h1").innerHTML = "Draw!";
}

//###########confetti#######################
const button = document.querySelector('#button');
const canvas = document.querySelector('#confetti');

const jsConfetti = new JSConfetti();

button.addEventListener('click', () => {
jsConfetti.addConfetti({
    emojis: ['🌈', '⚡️', '💥', '✨', '💫', '🌸'],
}).then(() => jsConfetti.addConfetti())
})

//###############################

    function refreshPage(){
        window.location.reload();
    } 


