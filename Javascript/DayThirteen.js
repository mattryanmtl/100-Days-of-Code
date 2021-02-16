function checkIsbn(id) {
    var isbnRe = /\d-?\d{4}-?\d{4}-?[\dX]$/;
    if (!isbnRe.test(id))
        return false;

    var testId = id.split('-').join(''),
        result = 0;
    for (var i = 0; i < testId.length; i++)
    {
        var cur = testId[i] === 'X' ? 10 : parseInt(testId[i]);
        result += cur * (10 - i);
    }
    return (result % 11) === 0;
}
