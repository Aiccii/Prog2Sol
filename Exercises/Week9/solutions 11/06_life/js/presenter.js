import {model,createGrid,getCell,nextGrid} from "./model.js"

const WIDTH=15;
const HEIGHT=10;
const gridSection=document.getElementById("grid")

init();


function getBoxes() {
  return gridSection.getElementsByTagName("input")
}


function createBoard(width, height) {
  let gridHTML = ""
  for (let y = 0; y < height; y++) {
    for (let x = 0; x < width; x++) {
      gridHTML += "<input type='checkbox' >"
    }
    gridHTML += "</br>"
  }
  gridSection.innerHTML = gridHTML;
}

function updateView() {
  let boxes = getBoxes()
  let count = 0
  for (let y = 0; y < HEIGHT; y++) {
    for (let x = 0; x < WIDTH; x++) {
      boxes[count].checked=getCell(model,x,y)
      count++
    }
  }
  return boxes
}

function nextGen() {
  nextGrid();
  updateView();
}

function addEventHandlers() {
  document.getElementById("next").addEventListener("click",nextGen)
}
function init(){

  createBoard(WIDTH,HEIGHT)
  createGrid(WIDTH,HEIGHT,1.0/3)
  updateView()
  addEventHandlers()
}