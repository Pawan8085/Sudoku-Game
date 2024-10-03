document.addEventListener('DOMContentLoaded', () => {
    const container = document.getElementById('sudoku-container');

    // Create the 9x9 grid
    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            const cell = document.createElement('div');
            cell.className = 'sudoku-cell';
            cell.id = `cell-${i}-${j}`;
            container.appendChild(cell);
        }
    }

    // Add event listener to the container
    container.addEventListener('click', (event) => {
        const target = event.target;
        if (target.classList.contains('sudoku-cell')) {
            alert(`Clicked on cell with ID: ${target.id}`);
            // Additional logic here
        }
    });
});
