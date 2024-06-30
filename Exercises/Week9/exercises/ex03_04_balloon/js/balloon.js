"use strict";

let textArea;

init();

function init() {
    document.addEventListener("keydown", handleKeyboardEvent);
}  // init()

function handleKeyboardEvent(event) {
    const MIN_SIZE = 5;
    const MAX_SIZE = 100;
    const DELTA = 5;

    let paragraph = document.getElementById("balloon");

    let size = parseInt(window.getComputedStyle(paragraph).fontSize);

    if (event.key === "ArrowUp") {
        size += DELTA;
    } else if (event.key === "ArrowDown") {
        size -= DELTA;
    }

    if ((size > MIN_SIZE) && size < MAX_SIZE) {
        paragraph.style.fontSize = size + "px";
    }
}  // handleKeyboardEvent()
