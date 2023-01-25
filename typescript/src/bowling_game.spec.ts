import { ScoreCalculator } from './score_calculator';

describe('Bowling', () => {

    let calculator: ScoreCalculator

    it('test empty card return 0', () => {        
        calculator = new ScoreCalculator()
        let result: Number = calculator.calculate("--------------------")
        expect(result).toEqual(0)
    });

    it('tests card with 1s only', () => {        
        calculator = new ScoreCalculator()
        let result: Number = calculator.calculate("11111111111111111111")
        expect(result).toEqual(20)
    });


    it('tests no spares no strikes pin-sum only', () => {        
        calculator = new ScoreCalculator()
        let result: Number = calculator.calculate("12345123451234512345")
        expect(result).toEqual(60)
    });

    it('tests one spare not at the end', () => {        
        calculator = new ScoreCalculator()
        let result: Number = calculator.calculate("/9111111111111111111")
        expect(result).toEqual(46)
    });

    it('tests one spare at the end', () => {        
        calculator = new ScoreCalculator()
        let result: Number = calculator.calculate("1111111111111111111/1")
        expect(result).toEqual(30)
    });

    it('tests one spare at the end', () => {        
        calculator = new ScoreCalculator()
        let result: Number = calculator.calculate("X981111111111111111")
        expect(result).toEqual(60)
    });

    it('tests one strike not at the end', () => {        
        calculator = new ScoreCalculator()
        let result: Number = calculator.calculate("X981111111111111111")
        expect(result).toEqual(60)
    });

    it('tests one strike at the end wrong card no additional tries', () => {        
        calculator = new ScoreCalculator()
        let result: Number = calculator.calculate("1111111111111111111X")
        expect(result).toEqual(29)
    });

    it('tests one strike at the end', () => {        
        calculator = new ScoreCalculator()
        let result: Number = calculator.calculate("111111111111111111X11")
        expect(result).toEqual(30)
    });

    it('tests max game result', () => {        
        calculator = new ScoreCalculator()
        let result: Number = calculator.calculate("XXXXXXXXXXXX")
        expect(result).toEqual(300)
    });


});
