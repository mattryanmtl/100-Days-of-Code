class App extends React.Component {

  render() {
    return /*#__PURE__*/(
      React.createElement(CurrencyConverter, null));

  }}


class CurrencyConverter extends React.Component {
  constructor() {
    super();

    this.state = {
      baseCurrency: 'GBP',
      convertToCurrency: 'USD',
      baseAmount: 100,
      rates: [],
      currencies: [] };


    this.changeBaseCurrency = this.changeBaseCurrency.bind(this);
    this.changeConvertToCurrency = this.changeConvertToCurrency.bind(this);
    this.changeBaseAmount = this.changeBaseAmount.bind(this);
    this.getConvertedCurrency = this.getConvertedCurrency.bind(this);
    this.callAPI = this.callAPI.bind(this);
  }

  componentDidMount() {
    this.callAPI(this.state.baseCurrency);
  }

  changeBaseCurrency(e) {
    this.setState({ baseCurrency: e.target.value });
    this.callAPI(e.target.value);

  }

  callAPI(base) {
    const api = `https://api.exchangeratesapi.io/latest?base=${base}`;

    fetch(api).
    then(results => {
      return results.json();
    }).then(data => this.setState({
      rates: data['rates'],
      currencies: Object.keys(data['rates']).sort() }));


  }


  changeConvertToCurrency(e) {
    this.setState({
      convertToCurrency: e.target.value });

  }

  changeBaseAmount(e) {
    this.setState({
      baseAmount: e.target.value });

  }

  getConvertedCurrency(baseAmount, convertToCurrency, rates) {
    return Number.parseFloat(baseAmount * rates[convertToCurrency]).toFixed(3);
  }

  render() {
    const { currencies, rates, baseCurrency, baseAmount, convertToCurrency } = this.state;

    const currencyChoice = currencies.map((currency) => /*#__PURE__*/
    React.createElement("option", { key: currency, value: currency }, " ", currency, " "));


    const result = this.getConvertedCurrency(baseAmount, convertToCurrency, rates);


    return /*#__PURE__*/(
      React.createElement("div", { className: "form-container" }, /*#__PURE__*/
      React.createElement("form", { className: "ui mini form" }, /*#__PURE__*/

      React.createElement("h3", null, "Convert from: ", baseCurrency), /*#__PURE__*/
      React.createElement("select", { value: baseCurrency, onChange: this.changeBaseCurrency },
      currencyChoice, /*#__PURE__*/
      React.createElement("option", null, baseCurrency)), /*#__PURE__*/


      React.createElement("h3", null, "Convert to: ", convertToCurrency), /*#__PURE__*/
      React.createElement("select", { value: convertToCurrency, onChange: this.changeConvertToCurrency },
      currencyChoice), /*#__PURE__*/


      React.createElement("h3", null, "Amount:"), /*#__PURE__*/
      React.createElement("input", { type: "number",
        id: "base-amount",
        defaultValue: baseAmount,
        onChange: this.changeBaseAmount })), /*#__PURE__*/


      React.createElement("h2", { id: "result-text" }, baseAmount, " ", baseCurrency, " is equal to ", result, " ", convertToCurrency)));


  }}



ReactDOM.render( /*#__PURE__*/
React.createElement(App, null),
document.getElementById('app'));
