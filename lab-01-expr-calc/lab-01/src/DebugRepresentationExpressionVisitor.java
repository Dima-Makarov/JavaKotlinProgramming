public class DebugRepresentationExpressionVisitor implements ExpressionVisitor {

    @Override
    public Object visitBinaryExpression(BinaryExpression expr) {
        String left_result = (String) expr.getLeft().accept(this);
        String right_result = (String) expr.getRight().accept(this);
        String our_result = switch (expr.getOperation()) {
            case plus -> "add(";
            case minus -> "sub(";
            case mult -> "mult(";
            case div -> "div(";
        };
        return our_result + left_result + ", " + right_result + ")";
    }

    @Override
    public Object visitLiteral(Literal expr) {
        return String.valueOf(expr.getValue());
    }

    @Override
    public Object visitVariable(VariableLiteral expr) {
        return expr.getName();
    }
}
