import {FormControl, InputLabel, Select} from "@mui/material";
import {Control, Controller, ControllerProps, FieldPath, FieldValues} from "react-hook-form";
import {SelectProps} from "@mui/material/Select/Select";

interface ISelectFieldFormProps<Value, TFieldValues extends FieldValues = FieldValues, TName extends FieldPath<TFieldValues> = FieldPath<TFieldValues>, TContext = any>{
  name: string
  label: string
  control: Control<TFieldValues, TContext>
  rules?: ControllerProps<TFieldValues, TName>["rules"]
  children: SelectProps<Value>['children']
  selectProps?: SelectProps<Value>
  controllerProps?: Omit<ControllerProps<TFieldValues, TName>, "control">
}

const CSelectFieldForm = <Value,>({ control, name, label, selectProps, controllerProps, rules, children }: ISelectFieldFormProps<Value>) => (
  <Controller
    render={({ field }) => (
      <FormControl {...field} className={"w-full"}>
        <InputLabel id={`${name}Label`}>Пол</InputLabel>
        <Select
          labelId={`${name}Label`}
          required={!!rules?.required}
          {...{
            ...selectProps,
            label,
            id: name,
          }}
        >
          {children}
        </Select>
      </FormControl>
    )}
    {...{
      ...controllerProps,
      name,
      control,
      rules,
    }}
  />
)

export default CSelectFieldForm
