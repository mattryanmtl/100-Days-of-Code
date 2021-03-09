function App() {
  const [input1, setInput1] = useState(0);
  const [input2, setInput2] = useState(0);
  const [total, setTotal] = useState(input1 + input2);

  function calculateTotal() {
    setTotal(input1 + input2);
  }

  return (
    <div className="App">
      <h1>Adding Machine</h1>
      <p>This very basic app allows you to add any two integers including negative values.</p>
      <div className="number-inputs">
        <input
          type="number"
          value={input1}
          onChange={e => setInput1(+e.target.value)}
          placeholder="0"
        />
        <input
          type="number"
          value={input2}
          onChange={e => setInput2(+e.target.value)}
          placeholder="0"
        />
      </div>

      <button onClick={calculateTotal}>Compute</button>

      <h2>{total}</h2>

    </div>
  );
}
