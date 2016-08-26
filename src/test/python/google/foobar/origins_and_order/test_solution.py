#!/usr/bin/env python

import imp
from nose.tools import eq_

solution_location = "../../../../../main/python/google/foobar/origins_and_order/solution.py"
solution = imp.load_source("solution", solution_location)

def test_solution():
    eq_('03/19/19', solution.answer(19, 19, 3))
    eq_('Ambiguous', solution.answer(3, 30, 3))
    eq_('Ambiguous', solution.answer(1, 1, 3))
    eq_('01/01/01', solution.answer(1, 1, 1))
    eq_('11/13/99', solution.answer(99, 11, 13))
    eq_('Ambiguous', solution.answer(12, 31, 30))
    eq_('02/28/29', solution.answer(2, 28, 29))
    eq_('Ambiguous', solution.answer(2, 12, 12))


test_solution()