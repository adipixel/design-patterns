import unittest

def isOdd(num):
    return num % 2 != 0

class UnitTesting(unittest.TestCase):
    def testOne(self):
        self.assertTrue(isOdd(5))

    def testTwo(self):
        self.assertFalse(isOdd(4))

def main():
    unittest.main()

if __name__ == '__main__':
    main()
