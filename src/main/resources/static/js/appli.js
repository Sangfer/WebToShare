const React = require('react');
const ReactDOM = require('react-dom')
const client = require('./client');


class ItemApp extends React.Component{
constructor(props) {
		super(props);
		this.state = {items: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/items'}).done(response => {
			this.setState({items: response.entity._embedded.items});
		});
	}

	render() {
		return (
			<ItemList item={this.state.items}/>
		)
	}
}

class ItemList extends React.Component{
	render() {
		var items = this.props.items.map(item =>
			<Item key={item._links.self.href} item={item}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>id</th>
						<th>name</th>
						<th>bonusStat</th>
                                                <th>itemClass</th>
					</tr>
					{items}
				</tbody>
			</table>
		)
	}
}

class Item extends React.Component{
	render() {
		return (
			<tr>
                                <td>{this.props.item.id}</td>
                        	<td>{this.props.item.name}</td>
				<td>{this.props.item.bonusStat}</td>
				<td>{this.props.item.itemClass}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<ItemApp />,
	document.getElementById('react')
)

