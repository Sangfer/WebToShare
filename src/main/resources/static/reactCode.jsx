
var CompteurClickable = React.createClass({
  render: function() {
    return <div onClick={ this.props.siClick }>
      Compteur {this.props.valeur}
    </div>
  }
})

var MonApp = React.createClass({
  getInitialState: function() {
    var etat = {};
    etat.valeurCompteur = this.props.start;
    return etat;
  },
  addOneToCounter: function() {
    this.state.valeurCompteur += 1;
    this.setState(this.state);
  },
  render: function() {
    return <div>
      <CompteurClickable siClick={this.addOneToCounter} valeur={this.state.valeurCompteur}></CompteurClickable>
      <CompteurClickable siClick={this.addOneToCounter} valeur={this.state.valeurCompteur}></CompteurClickable>
      <button onClick={ this.addOneToCounter }>+1</button>
    </div>
  }
  // margin-height (CSS) -> marginHeight (JS et React)
});

ReactDOM.render(
    <MonApp start={10}></MonApp>,
    document.getElementById('container')
  );
