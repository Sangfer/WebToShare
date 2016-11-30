var Table = Reactable.Table,
    Thead = Reactable.Thead,
    Th = Reactable.Th,
    Tr = Reactable.Tr,
    Td = Reactable.Td;

ReactDOM.render(
    <Table className="table" id="table">
        <Thead>
          <Th column="name">
            <strong className="name-header">First Name, Last Name</strong>
          </Th>
          <Th column="age">
            <em className="age-header">Age, years</em>
          </Th>
        </Thead>
        <Tr>
            <Td column="name" data="Griffin Smith">
                <b>Griffin Smith</b>
            </Td>
            <Td column="age">18</Td>
        </Tr>
        <Tr>
            <Td column="name">Lee Salminen</Td>
            <Td column="age">23</Td>
        </Tr>
        <Tr>
            <Td column="position">Developer</Td>
            <Td column="age">28</Td>
        </Tr>
    </Table>,
    document.getElementById('table')
);