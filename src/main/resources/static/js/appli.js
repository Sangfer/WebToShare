class VegeApp extends React.Component{
    
    constructor(props){
        super(props);
            this.state= {veges: [
                    {name: "Tomato", color: "red", price: "10"},
                    {name: "Cucumber", color:"green", price: "5"},
            ]};
        
    }
    
    
    render(){
        return (
                <h1> {this.props.titre} <b>toto</b></h1>
                )
    }
}


ReactDom.render(
        <VegeApp> Hello <em>hardcoded</em></VegeApp>,
        document.getElementById('container')        
        );