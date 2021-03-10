import React from 'react';
import yup from 'yup';

const FormComponent = ({ values, errors, onChange, onBlur, onSubmit }) => (
  <form onSubmit={onSubmit}>
    <input onChange={onChange} value={values.email} error={errors.email} />
  </form>
);

const Form = createForm({
  validations: {
    email: yup.string().email().required()
  },
  adapter: 'yup'
})(FormComponent);

class PageWithForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = { errors: {} };
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit({ values, errors, isValid }) {
    this.props.createResource(values).catch((err) => this.setState({ errors: err }));
  }

  render() {
    return <Form errors={errors} onSubmit={this.handleSubmit} />
  }
}

const mapStateToProps = () => ({});
const mapDispatchToProps = (dispatch) => ({
  createResource: (resourceProps) => dispatch(saveResource(resourceProps)),
});

export default connect(mapStateToProps, mapDispatchToProps)(PageWithForm);
