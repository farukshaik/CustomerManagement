import { Lookupdata } from './lookupdata';

export class Occupation {


    constructor(
        public employeeId:string,
        public employeeNature:string,
        public companyName:string,
        public  designation:string,
        public experience:number,
        public address:string,
        public state:string,
        public country:string,
        public pinCode:string,
        public custId:number
        

    ){}
}
