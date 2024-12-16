let startPoint;
let endPoint;

function createTable(rows, cols) {
  const table = document.createElement("table"); // <table> 요소 생성
  table.border = "1"; // 테이블 테두리 추가
  let totalClicks = 0; // 총 클릭 횟수

  for (let i = 0; i < rows; i++) {
    const tr = document.createElement("tr");

    for (let j = 0; j < cols; j++) {
      const td = document.createElement("td");
      td.style.padding = "20px"; // 셀 크기 조정
      td.style.textAlign = "center";

      // 초기 클릭 상태를 저장
      td.dataset.clicks = 0;

      // 클릭 이벤트 등록
      td.addEventListener("click", () => {
        if (totalClicks === 0) {
          // 첫 번째 클릭: 시작 지점 설정
          startPoint = { row: i, col: j };
          td.style.backgroundColor = "red";
          console.log(`Start Point: (${i}, ${j})`);
        } else if (totalClicks === 1) {
          // 두 번째 클릭: 끝 지점 설정
          endPoint = { row: i, col: j };
          td.style.backgroundColor = "yellow";
          console.log(`End Point: (${i}, ${j})`);
        } else {
          td.style.backgroundColor = "black";
        }

        totalClicks++; // 클릭 횟수 증가
      });

      tr.appendChild(td);
    }

    table.appendChild(tr);
  }
  document.body.appendChild(table); // 최종적으로 <table>을 DOM에 추가
}

// 5x5 테이블 생성
createTable(50, 50);
// 10x10 격자 생성

class position {
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }
}

class Node {
  constructor(x, y) {
    this.position = { x, y };
    this.parent = null;
    this.f = Infinity;
    this.g = Infinity;
  }
}

const rows = 30; // 행 개수
const cols = 30; // 열 개수

const grid = [];
for (let i = 0; i < rows; i++) {
  const row = [];
  for (let j = 0; j < cols; j++) {
    row.push(`${i},${j}`); // 좌표 형태로 데이터 추가
  }
  grid.push(row);
}

let open = [];
let closed = [];

const dx = [-1, 1, 0, 0, -1, -1, 1, 1]; // x 방향 (행)
const dy = [0, 0, -1, 1, -1, 1, -1, 1]; // y 방향 (열)

open.push(new Node(1, 3, 0, 0));
console.log(open);

while (!open.length === 0) {
  let cur = open[0];
  for (let i = 0; i < 4; i++) {
    let x = dx[i] + cur.x;
    let y = dy[i] + cur.y;

    if (x < rows && y < cols && x >= 0 && y >= 0 && isBlocked()) {
        if(open.)
      open(
        new Node(x, y, cur, g + manhattanDistance(x, y, 10, 10), cur.g + 10)
      );
      open.sort((a, b) => a.f - b.f);
    }

    for (let i = 4; i < 8; i++) {
      open(new Node(x, y, g + manhattanDistance(x, y, 10, 10), cur.g + 14));
      open.sort((a, b) => a.f - b.f);
    }

    close.push(cur);
  }
}
