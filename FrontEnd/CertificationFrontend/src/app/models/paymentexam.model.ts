import { Training } from "./training.model"

export class PaymentTraining {
    paymentMode: string
    paymentDate: Date
    amount: number
    userId: number
    training: Training
    expMonth: string
    expYear: number
    cardNum: string
    cvv: number
}